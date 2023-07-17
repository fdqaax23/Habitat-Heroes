use habitat_heroes::{
    hero_types::{Heroes, Villains},
    story_arc::{Plot, Resolution},
    utils::{
        introduction::Intro,
        outro::Outro,
        sound_effects::SoundEffects,
    },
    items::{
        weapons::{RocketLauncher, FreezeRay},
        armor::{ArmorSet, Shield},
    },
};

static INTRO: Intro = Intro {
    sound_effects: SoundEffects::Intro,
    description: String::from("Welcome to Habitat Heroes!"),
};

fn main() {
    println!("{}", INTRO);

    let hero = Heroes::ClawMan;
    let villain = Villains::Penguin;
    let plot = Plot::new(hero, villain);

    battle(plot, hero);
}

fn battle(plot: Plot, hero: Heroes) {
    let rocket_launcher = RocketLauncher::new();
    let freeze_ray = FreezeRay::new();

    println!("The hero is equipped with a {:#?} and a {:#?}!", rocket_launcher, freeze_ray);

    let shield = Shield::new();
    let armor_set = ArmorSet::new(shield);

    println!("The hero is wearing a {:#?}!", armor_set);
    println!("The villain is a {:#?}", plot.villain);

    println!("The heroes must battle the villain in an epic showdown!");

    let resolution = Resolution::new(plot);

    println!("{}", resolution);

    println!("The heroes have won the day!");

    static OUTRO: Outro = Outro {
        sound_effects: SoundEffects::Outro,
        description: format!("{}, You are a true hero!", hero.name()),
    };

    println!("{}", OUTRO);
}