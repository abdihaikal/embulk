package org.quickload.record;

public class BooleanReader
        extends TypeReader
{
    public BooleanReader(PageReader reader, Column column)
    {
        super(reader, column);
    }

    @Override
    void callRecordReader(RecordReader visitor)
    {
        if (reader.isNull(column.getIndex())) {
            visitor.readNull(column);
        } else {
            visitor.readBoolean(column, reader.getPage().getByte(reader.getOffset(column.getIndex())) == (byte) 1 ? true : false);
        }
    }
}