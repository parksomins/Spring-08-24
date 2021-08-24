package com.koreait.day3.service;

import com.koreait.day3.ifs.CrudInterface;
import com.koreait.day3.model.entity.Item;
import com.koreait.day3.model.enumclass.ItemStatus;
import com.koreait.day3.model.network.Header;
import com.koreait.day3.model.network.request.ItemApiRequest;
import com.koreait.day3.model.network.response.ItemApiResponse;
import com.koreait.day3.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // 서비스레이어, 내부에서 자바로직을 처리함
@RequiredArgsConstructor
public class ItemApiLogicService implements CrudInterface<ItemApiRequest, ItemApiResponse> {
    private final ItemRepository itemRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        ItemApiRequest itemApiRequest = request.getData();

        Item item = Item.builder()
                .name(itemApiRequest.getName())
                .status(ItemStatus.REGISTERED)
                .title(itemApiRequest.getTitle())
                .content(itemApiRequest.getContent())
                .price(itemApiRequest.getPrice())
                .build();
        Item newItem = itemRepository.save(item);
        return response(newItem);
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        return itemRepository.findById(id)
                .map(item -> response(item))
                .orElseGet(
                        () -> Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        ItemApiRequest itemApiRequest = request.getData();
        Optional<Item> optional = itemRepository.findById(itemApiRequest.getId());
        return optional.map(item -> {

                    item.setName(itemApiRequest.getName());
                    item.setStatus(itemApiRequest.getStatus());
                    item.setTitle(itemApiRequest.getTitle());
                    item.setContent(itemApiRequest.getContent());
                    item.setPrice(itemApiRequest.getPrice());

                    return item;
                }).map(item -> itemRepository.save(item))
                .map(item -> response(item))
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        Optional<Item> optional = itemRepository.findById(id);

        return optional.map(item -> {
            itemRepository.delete(item);
            return Header.OK();
        }).orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<ItemApiResponse> response(Item item){
        ItemApiResponse itemApiResponse = ItemApiResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .status(item.getStatus())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .regDate(item.getRegDate())
                .createBy(item.getCreateBy())
                .updateDate(item.getUpdateDate())
                .updateBy(item.getUpdateBy())
                .build();
        return Header.OK(itemApiResponse);
    }
}
