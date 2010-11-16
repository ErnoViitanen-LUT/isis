package org.apache.isis.viewer.bdd.common;


/**
 * Simply holds the text.
 * 
 */
public class StoryCellDefault implements StoryCell {

    private String source;

    public StoryCellDefault(String source) {
        this.source = source;
    }

    @Override
    public String getText() {
        return source;
    }

    @Override
    public void setText(String str) {
        this.source = str;
    }

    /**
     * The implementation-specific representation of this text.
     */
    @Override
    public Object getSource() {
        return source;
    }

}
