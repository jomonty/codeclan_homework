const Traveller = function(journeys) {
  this.journeys = journeys;
};

Traveller.prototype.getJourneyStartLocations = function() {
  return this.journeys.map(journey => journey.startLocation);
};

Traveller.prototype.getJourneyEndLocations = function () {
  return this.journeys.map(journey => journey.endLocation);
};

Traveller.prototype.getJourneysByTransport = function (transport) {
  return this.journeys.filter(journey => journey.transport === transport);
};

Traveller.prototype.getJourneysByMinDistance = function (minDistance) {
  return this.journeys.filter(journey => journey.distance >= minDistance);
};

Traveller.prototype.calculateTotalDistanceTravelled = function () {
  return this.journeys.reduce(
    (total, journey) => total + journey.distance, 0
  );
};

Traveller.prototype.getUniqueModesOfTransport = function () {
// Less readable but works
  // return this.journeys.map(journey => journey.transport).filter((transport, index, self) => {
  //     return self.indexOf(transport) === index;
  //   }
  // );
  const transportArray = this.journeys.map(journey => journey.transport);

  return transportArray.filter( (transport, index) => {
    return transportArray.indexOf(transport) === index;
  });
};

module.exports = Traveller;
