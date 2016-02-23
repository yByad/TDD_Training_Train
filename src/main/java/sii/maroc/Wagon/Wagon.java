package sii.maroc.Wagon;

import sii.maroc.Types.WagonTypes;

class Wagon {

    private WagonTypes Type;

    Wagon(WagonTypes type) {
	this.Type = type;
    }

    Boolean canBeFilled() {
	return this.isOfType(WagonTypes.Cargo_Unfilled);
    }

    WagonTypes getType() {
	return Type;
    }

    boolean fill() {
	this.Type = WagonTypes.Cargo_Filled;
	return true;
    }

    boolean isOfType(WagonTypes type) {
	return this.Type.isOfType(type);
    }

}
