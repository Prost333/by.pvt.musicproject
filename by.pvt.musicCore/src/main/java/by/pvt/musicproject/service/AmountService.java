package by.pvt.musicproject.service;

import by.pvt.musicproject.dto.AmountReq;
import by.pvt.musicproject.dto.AmountRes;
import by.pvt.musicproject.entity.Album;
import by.pvt.musicproject.entity.Amount;
import by.pvt.musicproject.entity.Performer;

import java.util.List;
import java.util.Optional;

public interface AmountService {
    AmountRes add(AmountReq amountReq);
    List<AmountRes> findAll();
    Long getAmount();
    void  delete(Long id);

}
