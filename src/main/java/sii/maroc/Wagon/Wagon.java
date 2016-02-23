package sii.maroc.Wagon;

import sii.maroc.presentation.wagonPresentations;

public class Wagon {

    private WagonTypes Type;

    Wagon(WagonTypes type) {
	this.Type = type;
    }

    String retrieveWagonFormat() {
	final wagonPresentations presentation = new wagonPresentations();
	final String wagonFormat = presentation.getPresentation(Type);
	return wagonFormat;
    }

    Boolean canBeFilled() {
	return this.isOfType(WagonTypes.Cargo_Unfilled);
    }

    boolean fill() {
	this.Type = WagonTypes.Cargo_Filled;
	return true;
    }

    boolean isOfType(WagonTypes type) {
	return this.Type.isOfType(type);
    }

}
