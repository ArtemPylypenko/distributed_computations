package main

import "fmt"

type User struct {
	name         string
	currentQueue int
}

func startRegister(queue1 chan User, queue2 chan User, currentQueue int, exit chan bool) {
	for len(queue1) > 0 || len(queue2) > 0 {
		if len(queue1) == 0 {
			customer := <-queue2
			queue1 <- customer
			fmt.Println("Customer", customer.name, "came to", currentQueue, "queue")
		}
		customer := <-queue1
		fmt.Println("Serviced customer", customer.name, "in", currentQueue, "queue")
		fmt.Println(currentQueue, "queue has", len(queue1), "customers")
		len1 := len(queue1)
		len2 := len(queue2)
		if len1 > len2+1 {
			customer := <-queue1
			queue2 <- customer
			fmt.Println("Customer", customer.name, "left", currentQueue, "queue")
		}
	}
	exit <- true
}

func main() {
	customer1 := User{name: "customer1", currentQueue: 1}
	customer2 := User{name: "customer2", currentQueue: 1}
	customer3 := User{name: "customer3", currentQueue: 2}
	customer4 := User{name: "customer4", currentQueue: 2}
	customer5 := User{name: "customer5", currentQueue: 1}
	customer6 := User{name: "customer6", currentQueue: 1}

	queue1 := make(chan User, 6)
	queue2 := make(chan User, 6)
	exit := make(chan bool, 1)

	queue1 <- customer6
	queue1 <- customer5
	queue1 <- customer1
	queue1 <- customer2

	queue2 <- customer3
	queue2 <- customer4

	go startRegister(queue1, queue2, 1, exit)
	go startRegister(queue2, queue1, 2, exit)
	<-exit
}