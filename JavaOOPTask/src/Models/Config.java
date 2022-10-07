package Models;

import java.util.List;

public class Config {
    private String readType;
    private String writeType;
    private String source;
    private ReadingProperties readingProperties;

    public Config() {
    }

    public Config(String readType, String writeType, String source, ReadingProperties readingProperties) {
        this.readType = readType;
        this.writeType = writeType;
        this.source = source;
        this.readingProperties = readingProperties;
    }

    public ReadingProperties getReadingProperties() {
        return readingProperties;
    }

    public String getReadType() {
        return readType;
    }

    public String getSource() {
        return source;
    }

    public String getWriteType() {
        return writeType;
    }

    public void setReadingProperties(ReadingProperties readingProperties) {
        this.readingProperties = readingProperties;
    }

    public void setReadType(String readType) {
        this.readType = readType;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setWriteType(String writeType) {
        this.writeType = writeType;
    }

    @Override
    public String toString() {
        return this.readType + " " + this.writeType + " " + this.source + " " + this.readingProperties.toString();
    }
}
