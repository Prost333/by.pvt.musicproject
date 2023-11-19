package by.pvt.musicproject.aop.verification;

import by.pvt.musicproject.entity.Subscription;
import by.pvt.musicproject.entity.User;
import by.pvt.musicproject.repository.DaoUser;
import by.pvt.musicproject.service.SubscriptionService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class CheckSubscriptionAspect {
    @Autowired
    private DaoUser daoUser;
    @Autowired
    private SubscriptionService subscriptionService;

    @Around("@annotation(CheckSubscription)")
    public Object checkSubscription(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        if (args.length > 0 && args[0] instanceof Long) {
            Long userId = (Long) args[0];
            User user = daoUser.findById(userId).orElse(null);
            if (user != null) {
                Subscription subscription = subscriptionService.findSubscriptionById(user.getSubscription().getId());
                if (subscription.getEndData().isAfter(LocalDateTime.now())) {
                    return joinPoint.proceed();
                }
            }
        }
        throw new RuntimeException("Подписка не активна");
    }
}

