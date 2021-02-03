package icon;

public enum BoardIcon {

    NOUGHT("NOUGHT", "0"),
    CROSS("CROSS", "X"),
    BLANK("BLANK", "-");
    
    private String name;
    private String character;
    
    private BoardIcon(String name, String character) {
	this.name = name;
	this.character = character;
    }
    
    public String getName() {
	return this.name;
    }
    
    public String toString() {
	return this.getCharacter();
    }
    
    public String getCharacter() {
	return this.character;
    }
    
    public Boolean equals(BoardIcon otherIcon) {
	return (this.name.equals(otherIcon.getName()) & this.character.equals(otherIcon.getCharacter()));
    }
}
