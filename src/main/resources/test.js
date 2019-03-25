
console.log("Testing in JS");

class Calculator {

    constructor() {
        this.value = 0;
    }

    add(amount) {
        this.value += amount;
    }
}

const calc = new Calculator();
calc.add(5);
calc.add(2);

if (calc.value !== 7) {
    throw "Wrong value " + calc.value;
}