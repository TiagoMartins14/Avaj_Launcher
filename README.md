# Avaj_launcher

_A 42 School Java OOP & Design Patterns Advanced Project_

---

## Project Description

**Avaj-Launcher** is an aviation simulation written in Java. It processes a `scenario.txt` file, creates aircraft with initial coordinates, and runs a multi‑cycle simulation where each aircraft reacts dynamically to changing weather conditions.

During each simulation step:

- The **WeatherProvider** determines the weather using aircraft coordinates.
- The **WeatherTower** broadcasts weather updates to all registered aircraft.
- Aircraft adjust their coordinates and altitude according to predefined rules.
- Landed aircraft automatically unregister from the tower.
- All events are logged into `simulation.txt`.

This project reinforces modular Java design, OOP principles, exception handling, and classical **GoF design patterns**.

---

## Project Structure

```
.
├── buildings
│   ├── Tower.java
│   └── WeatherTower.java
├── constants
│   └── Constants.java
├── exceptions
│   ├── InvalidAircraftFormatException.java
│   ├── InvalidAircraftTypeException.java
│   ├── InvalidSimulationRunsException.java
│   └── MissingAircraftException.java
├── flyables
│   ├── Aircraft.java
│   ├── aircrafts
│   │   ├── Balloon.java
│   │   ├── Coordinates.java
│   │   ├── Helicopter.java
│   │   └── JetPlane.java
│   └── Flyable.java
├── Makefile
├── scenario.txt
├── simulator
│   ├── Simulator.java
│   └── Validator.java
└── singletons
    ├── AircraftFactory.java
    ├── OutputFileWriter.java
    └── WeatherProvider.java
```

---

## Input Format (`scenario.txt`)

The first line declares the number of simulation cycles:

```
<number_of_simulation_cycles>
```

Every next line describes one aircraft:

```
<AircraftType> <Name> <Longitude> <Latitude> <Altitude>
```

Example:

```
15
Helicopter H2 10 22 35
JetPlane JP7 45 13 55
Balloon B9 2 34 12
```

---

##  Output (`simulation.txt`)

The simulator logs all significant events such as:

- Tower registration and unregistration  
- Weather‑dependent aircraft behavior  
- Position and altitude changes  
- Landing events  

Example excerpt:

```
Tower: JetPlane#JP7(3) registered to weather tower.
JetPlane#JP7(3): Oh boy, the sun is blinding me.
JetPlane#JP7(3): landing.
Tower: JetPlane#JP7(3) unregistered from weather tower.
```

---

## Key Components

### **Simulator**
Coordinates the entire simulation, loads data, validates inputs, and executes cycles.

### **Validator**
Ensures that `scenario.txt` follows valid formatting and constraints.

### **WeatherTower / Tower**
- Maintains a registry of all airborne aircraft.
- Notifies them of weather updates each cycle.

### **WeatherProvider (Singleton)**
Generates weather values deterministically based on coordinates.

### **Aircraft & Flyable**
Abstract representations of aircraft providing structure for concrete types.

### **Concrete Aircraft**
- **Balloon**
- **Helicopter**
- **JetPlane**

Each aircraft implements weather‑specific rules in `updateConditions()`.

### **Factory Method**
`AircraftFactory` builds aircraft instances based on type identifiers.

### **Custom Exceptions**
Provide robust handling of invalid types, malformed input, or missing data.

---

## Building & Running the Project

This project uses the included **Makefile**, which handles compilation, running, and cleanup.

### **Compile**

```bash
make
```

This uses:

```bash
find * -name "*.java" > sources.txt
javac @sources.txt
```

### **Run the Simulation**

```bash
make sim
```

Equivalent to:

```bash
java simulator.Simulator scenario.txt
```

### **Clean Build Artifacts**

```bash
make clean
```

Deletes all `.class` files, `simulation.txt`, and `sources.txt`.

---

## Learning Objectives

This project reinforces:

- Strong **Object‑Oriented Programming** principles  
- Clean modular architecture and package structuring  
- Custom exception handling  
- Three core **GoF Design Patterns**:

| Pattern | Implemented In | Purpose |
|--------|----------------|---------|
| **Singleton** | `WeatherProvider` | Ensures a single shared weather generator |
| **Factory Method** | `AircraftFactory` | Centralizes and abstracts aircraft creation |
| **Observer** | `Tower` ↔ `Flyable` | Enables dynamic weather notifications |

---

