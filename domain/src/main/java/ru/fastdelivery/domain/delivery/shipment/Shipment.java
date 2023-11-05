package ru.fastdelivery.domain.delivery.shipment;

import ru.fastdelivery.domain.common.weight.Weight;
import ru.fastdelivery.domain.delivery.pack.Pack;

import java.util.List;

public record Shipment(
        List<Pack> packages
) {
    public Weight weightAllPackages() {
        return packages.stream()
                .map(Pack::weight)
                .reduce(Weight.zero(), Weight::add);
    }
}
