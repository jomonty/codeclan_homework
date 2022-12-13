const Park = function (name, ticketPrice, collection) {
    this.name = name;
    this.ticketPrice = ticketPrice;
    this.collection = collection;
};

Park.prototype.addDino = function (dino) {
    this.collection.push(dino);
};

Park.prototype.removeDino = function (dino) {
    let index = this.collection.indexOf(dino);
    this.collection.splice(index, 1);
};

Park.prototype.highestVisitDino = function () {
    let index = 0;
    let highestVisit = this.collection[index];
    for (let i=0; i < this.collection.length; i++) {
        if (this.collection[i].guestsAttractedPerDay > highestVisit) {
            index = i;
            highestVist = this.collection[i].guestsAttractedPerDay;
        }
    }
    return this.collection[index];
};

Park.prototype.findDinoBySpecies = function (species) {
    let dinos = [];
    for (let dino of this.collection) {
        if (dino.species == species) {
            dinos.push(dino);
        }
    }
    return dinos;
};

Park.prototype.getTotalDailyVisitors = function () {
    let total = 0;
    for (let i=0; i < this.collection.length; i++) {
        total += this.collection[i].guestsAttractedPerDay;
    }
    return total;
};

Park.prototype.getTotalAnnualVisitors = function () {
    return this.getTotalDailyVisitors() * 365;
};

Park.prototype.getTotalAnnualRevenue = function () {
    return this.getTotalAnnualVisitors() * this.ticketPrice;
};

Park.prototype.removeAllBySpecies = function (species) {
    let newCollection = [];
    for (let i=0; i<this.collection.length; i++) {
        let dino = this.collection[i];
        if (dino.species !== species) {
            newCollection.push(dino);
        }
    }
    this.collection = newCollection;
};

Park.prototype.getSummaryDiets = function () {
    let summaryDiets = {};
    for (let i=0; i<this.collection.length; i++) {
        let dino = this.collection[i];
        let diet = dino.diet;
        if (diet in summaryDiets) {
            summaryDiets[diet]++;
        } else {
            summaryDiets[diet] = 1;
        }
    }
    return summaryDiets;
}
module.exports = Park;