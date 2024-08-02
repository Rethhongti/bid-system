package com.api.bid_system.modules.bid.services;

import com.api.bid_system.exceptions.NotFoundException;
import com.api.bid_system.modules.bid.BidRepository;
import com.api.bid_system.modules.bid.data.BidEntity;
import com.api.bid_system.modules.bid.data.BidMapper;
import com.api.bid_system.modules.bid.data.CreateBidRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService{
    private final BidRepository bidRepo;

    @Override
    public BidEntity createBidItem(CreateBidRequestDto payload) {
        BidEntity data = BidMapper.INSTANCE.toBidEntity(payload);

        System.out.println(data.getTitle());
        return bidRepo.save(data);
    }

    @Override
    public BidEntity getBidById(Integer id) {
        return bidRepo.findById(id).orElseThrow(() -> new NotFoundException("Bid not found!!!"));
    }
}
