package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() = this.orders.filter { it.isDelivered }.flatMap { it.products.toList() }.toHashSet()
    // Return all products this customer has ordered

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    val hasLeastOne: (Order) -> Boolean = { it.isDelivered }
    return this.customers.flatMap { it.orders.filter(hasLeastOne).flatMap { it.products.toList() } }.toHashSet()
}
