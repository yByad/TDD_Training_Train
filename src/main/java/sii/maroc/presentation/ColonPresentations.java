package sii.maroc.presentation;

enum ColonPresentations implements Presentations {

    Passenger("|OOOO|"), Head("<HHHH"), Head_Right("HHHH>"), Cargo_Unfilled("|____|"), Restaurant(
	    "|hThT|"), Cargo_Filled("|^^^^|"), Undefined("|%%%%|");
    private String wagon;

    private ColonPresentations(final String wagon) {
	this.wagon = wagon;
    }

    @Override
    public String value() {
	return this.wagon;
    }

}
