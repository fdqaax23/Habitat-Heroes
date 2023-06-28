//Habitat Heroes

//Modules
import * as React from 'react';
import { Redirect } from 'react-router-dom';
import { Link } from 'react-router-dom';

//Components
import { Menu, Main, Sidebar, Footer } from './components';

//Data
import data from './data'; 

//Interfaces
interface IState {
    name: string;
    habitatType: string;
    habitatRegion: string;
    habitatSubregions: string[];
    habitatLocation: string;
    animalResidents: string[];
    endangeredAnimals: string[];
    endangeredHabitats: string[];
    vulnerableAnimals: string[];
    vulnerableHabitats: string[];
    threatenedAnimals: string[];
    threatenedHabitats: string[];
    endangeredSpecies: string[];
    vulnerableSpecies: string[];
    threatenedSpecies: string[];
    conservationEfforts: string[];
    protectedAreas: string[];
    conservationOrganizations: string[];  
}

//Main component
class HabitatHeroes extends React.Component<{}, IState> {
    constructor(props: any) {
        super(props);
        this.state = {
            name: '',
            habitatType: '',
            habitatRegion: '',
            habitatSubregions: [],
            habitatLocation: '',
            animalResidents: [],
            endangeredAnimals: [],
            endangeredHabitats: [],
            vulnerableAnimals: [],
            vulnerableHabitats: [],
            threatenedAnimals: [],
            threatenedHabitats: [],
            endangeredSpecies: [],
            vulnerableSpecies: [],
            threatenedSpecies: [],
            conservationEfforts: [],
            protectedAreas: [],
            conservationOrganizations: []
        };
    }
  
    //Render the page
    render() {
        return (
            <div>
                <Menu />
                <Main />
                <Sidebar />
                <Footer />
            </div>
        )
    }
}

//Handlers
class HabitatHandler extends React.Component<{}, IState> {

    //Get habitat data
    getHabitatData = () => {
        const habitatData = data.habitats;
        this.setState({
            habitatName: habitatData.name,
            habitatType: habitatData.type,
            habitatRegion: habitatData.region,
            habitatSubregions: habitatData.subregions,
            habitatLocation: habitatData.location
        });
    }

    //Get animal residents
    getAnimalResidents = () => {
        const animalResidents = [];
        data.habitats.forEach((habitat) => {
            habitat.residents.forEach((residents) => {
                animalResidents.push(residents);
            });
        });
        this.setState({ animalResidents });
    }

    //Get endangered animals
    getEndangeredAnimals = () => {
        const endangeredAnimals = [];
        data.habitats.forEach((habitat) => {
            habitat.residents.forEach((residents) => {
                if (residents.endangered === true) {
                    endangeredAnimals.push(residents);
                }
            });
        });
        this.setState({ endangeredAnimals });
    }

    //Get endangered habitats
    getEndangeredHabitats = () => {
        const endangeredHabitats = [];
        data.habitats.forEach((habitat) => {
            if (habitat.endangered === true) {
                endangeredHabitats.push(habitat);
            }
        });
        this.setState({ endangeredHabitats });
    }

    //Get vulnerable animals
    getVulnerableAnimals = () => {
        const vulnerableAnimals = [];
        data.habitats.forEach((habitat) => {
            habitat.residents.forEach((residents) => {
                if (residents.vulnerable === true) {
                    vulnerableAnimals.push(residents);
                }
            });
        });
        this.setState({ vulnerableAnimals });
    }

    //Get vulnerable habitats
    getVulnerableHabitats = () => {
        const vulnerableHabitats = [];
        data.habitats.forEach((habitat) => {
            if (habitat.vulnerable === true) {
                vulnerableHabitats.push(habitat);
            }
        });
        this.setState({ vulnerableHabitats });
    }

    //Get threatened animals
    getThreatenedAnimals = () => {
        const threatenedAnimals = [];
        data.habitats.forEach((habitat) => {
            habitat.residents.forEach((residents) => {
                if (residents.threatened === true) {
                    threatenedAnimals.push(residents);
                }
            });
        });
        this.setState({ threatenedAnimals });
    }

    //Get threatened habitats
    getThreatenedHabitats = () => {
        const threatenedHabitats = [];
        data.habitats.forEach((habitat) => {
            if (habitat.threatened === true) {
                threatenedHabitats.push(habitat);
            }
        });
        this.setState({ threatenedHabitats });
    }

    //Get endangered species 
    getEndangeredSpecies = () => {
        const endangeredSpecies = [];
        endangeredAnimals.forEach((endangeredAnimal) => {
            endangeredSpecies.push(endangeredAnimal.species);
        });
        this.setState({ endangeredSpecies });
    }

    //Get vulnerable species 
    getVulnerableSpecies = () => {
        const vulnerableSpecies = [];
        vulnerableAnimals.forEach((vulnerableAnimal) => {
            vulnerableSpecies.push(vulnerableAnimal.species);
        });
        this.setState({ vulnerableSpecies });
    }

    //Get threatened species 
    getThreatenedSpecies = () => {
        const threatenedSpecies = [];
        threatenedAnimals.forEach((threatenedAnimal) => {
            threatenedSpecies.push(threatenedAnimal.species);
        });
        this.setState({ threatenedSpecies });
    }

    //Get conservation efforts
    getConservationEfforts = () => {
        const conservationEfforts = data.conservationEfforts;
        this.setState({ conservationEfforts });
    }

    //Get protected areas
    getProtectedAreas = () => {
        const protectedAreas = data.protectedAreas;
        this.setState({ protectedAreas });
    }

    //Get conservation organizations
    getConservationOrganizations = () => {
        const conservationOrganizations = data.conservationOrganizations;
        this.setState({ conservationOrganizations });
    }
    
    //Render the page
    render() {
        return (
            <div>
                <h1>Habitat Heroes</h1>
                <Link to={"/habitat"}>
                    <button>Explore Habitat</button>
                </Link>
                <Link to={"/conservation"}>
                    <button>Conservation</button>
                </Link>
            </div>
        )
    }
}

//Export 
export default HabitatHeroes;