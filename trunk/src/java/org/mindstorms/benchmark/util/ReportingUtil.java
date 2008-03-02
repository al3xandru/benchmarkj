package org.mindstorms.benchmark.util;

import org.mindstorms.benchmark.time.Times;

/**
 * @author <a href="mailto:the.mindstorm@gmail.com">Alex Popescu</a>
 * @since Feb 29, 2008
 */
public class ReportingUtil {
  public static String header(String format, Times... times) {
    return header(format, "",  times);
  }

  public static String header(String format, String capturePrefix,  Times... times) {
    int maxLabelLength= maxLabelLength(capturePrefix, getAllLabels(times));
    if(capturePrefix == null || "".equals(capturePrefix)) {
      return blanks(maxLabelLength <= 0 ? 1 : maxLabelLength + 3) + format;
    }
    else {
      int blanks= 3 + (maxLabelLength - capturePrefix.length());
      return capturePrefix
          + blanks(blanks)
          + format;
    }
  }

  public static String reportFormat(String format, Times... times) {
    return reportFormat(format, "", times);
  }

  public static String reportFormat(String format, String capturePrefix, Times... times) {
    int maxLength= maxLabelLength(capturePrefix, getAllLabels(times));
    String labelPrefixFormat;
    if(maxLength == 0) {
      labelPrefixFormat= "%1$-1s";
    }
    else {
      labelPrefixFormat= "%1$-" + (maxLength + 1) + "s: ";
    }
    return labelPrefixFormat + reportFormat(format);
  }
  
  private static String blanks(int size) {
    if(size <= 0) return "";

    StringBuffer buf= new StringBuffer(size);
    for(int i=0; i < size; i++) {
      buf.append(" ");
    }
    return buf.toString();
  }
  
  private static String[] getAllLabels(Times... times) {
    String[] labels= new String[times.length];
    int i= 0;
    for(Times t : times) {
      labels[i++]= t.getLabel();
    }

    return labels;
  }
  
  private static int maxLabelLength(String prefix, String... labels) {
    int maxLength= prefix != null ? prefix.length() : 0;
    if(labels == null || labels.length == 0) return maxLength;
    
    for(String s : labels) {
      if(s.length() > maxLength) {
        maxLength= s.length();
      }
    }

    return maxLength;
  }

  private static String reportFormat(String format) {
    int i= 1;
    StringBuffer buf= new StringBuffer(format);
    int idx= buf.indexOf("%$");
    while(idx != -1) {
      i++;
      buf.replace(idx, idx+1, "%" + i);
      idx= buf.indexOf("%$", idx + 2);
    }

    return buf.toString();
  }
}
