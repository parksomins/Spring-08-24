package com.koreait.day3.controller.api;

import com.koreait.day3.ifs.CrudInterface;
import com.koreait.day3.model.network.Header;
import com.koreait.day3.model.network.request.ItemApiRequest;
import com.koreait.day3.model.network.response.ItemApiResponse;
import com.koreait.day3.repository.ItemRepository;
import com.koreait.day3.service.ItemApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class ItemApiController implements CrudInterface<ItemApiRequest, ItemApiResponse> {
    private final ItemApiLogicService itemApiLogicService;

    @Override
    @PostMapping("")
    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
        return itemApiLogicService.create(request);
    }

    @Override
    @GetMapping("/api/user")
    public Header<ItemApiResponse> read(@PathVariable(name = "id") Long id) {
        return itemApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {

        return itemApiLogicService.update(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<ItemApiResponse> delete(@PathVariable(name = "id") Long id) {
        return itemApiLogicService.delete(id);
    }
}
