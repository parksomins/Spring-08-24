package com.koreait.day3.controller.api;

import com.koreait.day3.ifs.CrudInterface;
import com.koreait.day3.model.network.Header;
import com.koreait.day3.model.network.request.PartnerApiRequest;
import com.koreait.day3.model.network.response.PartnerApiResponse;
import com.koreait.day3.service.PartnerApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {
    private final PartnerApiLogicService partnerApiLogicService;

    @PostMapping("")
    @Override
    public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.create(request);
    }

    @GetMapping("/api/user")
    @Override
    public Header<PartnerApiResponse> read(@PathVariable(name = "id") Long id) {
        return partnerApiLogicService.read(id);
    }

    @PostMapping("")
    @Override
    public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.update(request);
    }

    @GetMapping("{id}")
    @Override
    public Header<PartnerApiResponse> delete(@PathVariable(name = "id") Long id) {
        return partnerApiLogicService.delete(id);
    }
}
