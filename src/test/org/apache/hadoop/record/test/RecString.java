// File generated by hadoop record compiler. Do not edit.
package org.apache.hadoop.record.test;

public class RecString implements org.apache.hadoop.record.Record, org.apache.hadoop.io.WritableComparable {
  private String mData;
  private java.util.BitSet bs_;
  public RecString() {
    bs_ = new java.util.BitSet(2);
    bs_.set(1);
  }
  public RecString(
        String m0) {
    bs_ = new java.util.BitSet(2);
    bs_.set(1);
    mData=m0; bs_.set(0);
  }
  public String getData() {
    return mData;
  }
  public void setData(String m_) {
    mData=m_; bs_.set(0);
  }
  public void serialize(org.apache.hadoop.record.OutputArchive a_, String tag) throws java.io.IOException {
    if (!validate()) throw new java.io.IOException("All fields not set:");
    a_.startRecord(this,tag);
    a_.writeString(mData,"Data");
    bs_.clear(0);
    a_.endRecord(this,tag);
  }
  public void deserialize(org.apache.hadoop.record.InputArchive a_, String tag) throws java.io.IOException {
    a_.startRecord(tag);
    mData=a_.readString("Data");
    bs_.set(0);
    a_.endRecord(tag);
}
  public String toString() {
    try {
      java.io.ByteArrayOutputStream s =
        new java.io.ByteArrayOutputStream();
      org.apache.hadoop.record.CsvOutputArchive a_ = 
        new org.apache.hadoop.record.CsvOutputArchive(s);
      a_.startRecord(this,"");
    a_.writeString(mData,"Data");
      a_.endRecord(this,"");
      return new String(s.toByteArray(), "UTF-8");
    } catch (Throwable ex) {
      ex.printStackTrace();
    }
    return "ERROR";
  }
  public void write(java.io.DataOutput out) throws java.io.IOException {
    org.apache.hadoop.record.BinaryOutputArchive archive = new org.apache.hadoop.record.BinaryOutputArchive(out);
    serialize(archive, "");
  }
  public void readFields(java.io.DataInput in) throws java.io.IOException {
    org.apache.hadoop.record.BinaryInputArchive archive = new org.apache.hadoop.record.BinaryInputArchive(in);
    deserialize(archive, "");
  }
  private boolean validate() {
    if (bs_.cardinality() != bs_.length()) return false;
    return true;
}
  public int compareTo (Object peer_) throws ClassCastException {
    if (!(peer_ instanceof RecString)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    RecString peer = (RecString) peer_;
    int ret = 0;
    ret = mData.compareTo(peer.mData);
    if (ret != 0) return ret;
     return ret;
  }
  public boolean equals(Object peer_) {
    if (!(peer_ instanceof RecString)) {
      return false;
    }
    if (peer_ == this) {
      return true;
    }
    RecString peer = (RecString) peer_;
    boolean ret = false;
    ret = mData.equals(peer.mData);
    if (!ret) return ret;
     return ret;
  }
  public int hashCode() {
    int result = 17;
    int ret;
    ret = mData.hashCode();
    result = 37*result + ret;
    return result;
  }
  public static String signature() {
    return "LRecString(s)";
  }
}
