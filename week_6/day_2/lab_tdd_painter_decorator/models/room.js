const Room = function (area, isPainted) {
    this.area = area;
    this.isPainted = false;
}

Room.prototype.paint = function () {
    this.isPainted = true;
}

Room.prototype.roomPainted = function () {
    return this.isPainted;
}

module.exports = Room;