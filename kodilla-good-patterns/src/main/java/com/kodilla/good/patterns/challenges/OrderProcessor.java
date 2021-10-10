package com.kodilla.good.patterns.challenges;

public class OrderProcessor {
    private InformationServices informationService;
    private OrderServices orderService;
    private OrderRepositories ordrRepository;

    public OrderProcessor(final InformationServices informationService,
                               final OrderServices orderService,
                               final OrderRepositories ordrRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.ordrRepository = ordrRepository;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isBought = orderService.order(orderRequest.getUser(), orderRequest.getProduct());

        if (isBought){
            informationService.inform(orderRequest.getUser(), orderRequest.getProduct());
            ordrRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
        }
    }
}
