package sii.maroc.Wagon;

public enum WagonTypes {

    P("|OOOO|"), H("<HHHH::"), Head_End("::HHHH>"), C("|____|"), R("|hThT|"), C_F("|^^^^|");

    private String wagon;

    private WagonTypes(final String wagon) {
	this.wagon = wagon;
    }

    public String value() {
	return this.wagon;
    }

}
