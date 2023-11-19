package by.pvt.musicproject.service.imp;

import by.pvt.musicproject.dto.AmountReq;
import by.pvt.musicproject.dto.AmountRes;
import by.pvt.musicproject.entity.Amount;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.mapper.AmountMapper;
import by.pvt.musicproject.repository.DaoAmount;
import by.pvt.musicproject.service.AmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmountServiceImp implements AmountService {
    private final AmountMapper amountMapper;
    private final DaoAmount dao;

    @Override
    @Transactional
    public AmountRes add(AmountReq amountReq) {
        Amount amount = amountMapper.toEntity(amountReq);
        dao.save(amount);
        return amountMapper.toResponse(amount);
    }
    @Override
    public Long getAmount(){
        Amount amount = dao.findAll().get(0);
     return amount.getAmount();
    }

    @Override
    public void delete(Long id) {
        dao.deleteById(id);
    }

    @Override
    public List<AmountRes> findAll() {
        return dao.findAll().stream().map(amountMapper::toResponse).collect(Collectors.toList());
    }


}
