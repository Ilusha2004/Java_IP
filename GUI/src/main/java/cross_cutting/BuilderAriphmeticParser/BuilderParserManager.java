package cross_cutting.BuilderAriphmeticParser;

import cross_cutting.EnumTypes.Extensions;

public interface BuilderParserManager {
    void setTypeExtension(Extensions extensions);
    void setParser();
    void setWriter();
}
