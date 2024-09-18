package com.spectrun.spectrum.services.Implementations;

import com.spectrun.spectrum.DTO.SubscriptionDTO;
import com.spectrun.spectrum.models.Plan;
import com.spectrun.spectrum.models.Subscriptions;
import com.spectrun.spectrum.repositories.PlanRepository;
import com.spectrun.spectrum.repositories.SubscriptionRepository;
import com.spectrun.spectrum.services.Isubscription;
import com.spectrun.spectrum.utils.exceptions.PlanNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.spectrun.spectrum.utils.mappers.subscriptionMapper.subscriptionDTOMapper;
import static com.spectrun.spectrum.utils.mappers.subscriptionMapper.subscriptionsMapper;

@Service
public class SubscriptionService implements Isubscription {
    private SubscriptionRepository subscriptionRepository;
    private PlanRepository planRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository,PlanRepository planRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.planRepository = planRepository;
    }

    @Override
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        long planId = subscriptionDTO.getPlanId();
        Plan plan = this.planRepository.findById(planId).orElseThrow(()-> new PlanNotFoundException("Subscription Plan Not Found"));

        Subscriptions newSubscription = subscriptionsMapper(subscriptionDTO);
        newSubscription.setPlan(plan);

        return subscriptionDTOMapper(newSubscription);
    }

    @Override
    public List<SubscriptionDTO> getAllSubscriptions() {
        List<Subscriptions> subscriptionList = this.subscriptionRepository.findAll();
        return subscriptionList.stream().map(subscriptions -> subscriptionDTOMapper(subscriptions)).collect(Collectors.toList());
    }
}
