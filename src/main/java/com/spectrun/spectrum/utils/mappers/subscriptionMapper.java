package com.spectrun.spectrum.utils.mappers;

import com.spectrun.spectrum.DTO.SubscriptionDTO;
import com.spectrun.spectrum.models.Subscriptions;

public class subscriptionMapper {

    public static Subscriptions subscriptionsMapper(SubscriptionDTO subscriptionDTO){
        Subscriptions subscriptions = Subscriptions
                .builder()
                .pricing(subscriptionDTO.getPricing())
                .status(subscriptionDTO.getStatus())
                .offers(subscriptionDTO.getOffers())
                .createdOn(subscriptionDTO.getCreatedOn())
                .updatedOn(subscriptionDTO.getUpdatedOn())
                .usageLimits(subscriptionDTO.getUsageLimits())
                .billing_cycle(subscriptionDTO.getBilling_cycle())
                .build();

        return subscriptions;
    }
    public static SubscriptionDTO subscriptionDTOMapper(Subscriptions subscriptions){
        SubscriptionDTO subscriptionDTO = SubscriptionDTO
                .builder()
                .pricing(subscriptions.getPricing())
                .status(subscriptions.getStatus())
                .offers(subscriptions.getOffers())
                .createdOn(subscriptions.getCreatedOn())
                .updatedOn(subscriptions.getUpdatedOn())
                .plan(subscriptions.getPlan())
                .usageLimits(subscriptions.getUsageLimits())
                .billing_cycle(subscriptions.getBilling_cycle())
                .build();

        return subscriptionDTO;
    }
}
