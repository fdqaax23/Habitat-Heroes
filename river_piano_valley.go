package main 

import (
	"fmt"
	"strings"
)

//HabitatHero is a representation of a hero in the game 
type HabitatHero struct {
	Name	string
	Power	string
	Level	int
}

//Upgrade increases the level of the hero
func (h *HabitatHero) Upgrade() {
	h.Level++
}

//UsePower uses a hero's power
func (h *HabitatHero) UsePower() {
	fmt.Printf("%s used %s!\n", h.Name, h.Power)
}

func main() {

	//Create new instance of HabitatHero
	h := HabitatHero{
		Name:  "Grendel",
		Power: "Ice Beam",
		Level: 1,
	}

	h.Upgrade()
	h.UsePower()
 
	//Print out the heroes name in CAPS
	fmt.Println(strings.ToUpper(h.Name))
}