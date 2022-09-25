package main

import "fmt"

func fight(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func tournament(all []int) int {
	var lens int
	if len(all)%2 == 0 {
		lens = len(all) / 2
	} else {
		lens = len(all)/2 + 1
	}
	new := make([]int, lens)
	for i := 0; i < lens; i++ {
		new[i] = fight(all[i], all[len(all)-i-1])
		//fmt.Print("   ", all[i], "  ", all[len(all)-i-1])
	}
	fmt.Print("\n")
	fmt.Print(new)
	if len(new) > 2 {
		return tournament(new)
	} else {
		return fight(new[0], new[1])
	}
}
func main() {
	powerInput := []int{46, 14, 1, 21, 44, 4, 21, 14, 6, 47, 35, 44, 10, 50, 20, 48, 23, 38, 41, 12}
	fmt.Print(powerInput, "\n")
	print("\n", "Ez trash ", tournament(powerInput))
}
