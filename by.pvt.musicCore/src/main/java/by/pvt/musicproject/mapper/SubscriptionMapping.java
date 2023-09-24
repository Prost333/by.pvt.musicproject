package by.pvt.musicproject.mapper;

import by.pvt.musicproject.dto.SubscriptionReq;
import by.pvt.musicproject.dto.SubscriptionRes;
import by.pvt.musicproject.entity.Subscription;

public class SubscriptionMapping {

    public SubscriptionRes toResponse(Subscription subscription) {
        SubscriptionRes subscriptionRes = new SubscriptionRes();
        subscriptionRes.setId(subscription.getId());
        subscriptionRes.setEndData(subscription.getEndData());
        subscriptionRes.setPlaylist_id(subscription.getPlaylist_id());
        subscriptionRes.setUser_id(subscription.getUser_id());
        subscriptionRes.setStartData(subscription.getStartData());
        subscriptionRes.setSubsPrice(subscription.getSubsPrice());
        return subscriptionRes;
    }

    public Subscription toSubscriptionEntity(SubscriptionReq subscriptionReq) {
        Subscription subscription = new Subscription();
        subscription.setId(subscriptionReq.getId());
        subscription.setEndData(subscriptionReq.getEndData());
        subscription.setPlaylist_id(subscriptionReq.getPlaylist_id());
        subscription.setUser_id(subscriptionReq.getUser_id());
        subscription.setStartData(subscriptionReq.getStartData());
        subscription.setSubsPrice(subscriptionReq.getSubsPrice());
        return subscription;
    }
}