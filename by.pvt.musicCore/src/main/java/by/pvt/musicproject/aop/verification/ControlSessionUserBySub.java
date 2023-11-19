package by.pvt.musicproject.aop.verification;

import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.SubscriptionService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class ControlSessionUserBySub {
    @Autowired
    private DaoUser dao;
    @Autowired
    private SubscriptionService subscriptionService;

    @Around("@annotation(ControlSessionUserBySubscription)")
    public Object checkSubscription(ProceedingJoinPoint joinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            User user = (User) authentication.getPrincipal();
            Subscription subscription = subscriptionService.findSubscriptionById(user.getSubscription().getId());
            if (subscription.getEndData().isAfter(LocalDateTime.now())) {
                return joinPoint.proceed();
            }
        }
        throw new RuntimeException("Подписка не активна");
    }
}
