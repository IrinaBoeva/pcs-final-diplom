import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class PageEntry implements Comparable<PageEntry> {
    //private final String pdfName;
    //private final int page;

    private String pdfName;
    private int page;
    private int count;

    public PageEntry() {
    }

    public PageEntry(String pdfName, int page, int count) {
        this.pdfName = pdfName;
        this.page = page;
        this.count = count;
    }

    public String getPdfName() {
        return pdfName;
    }

    public int getPage() {
        return page;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "\nPageEntry {\n " +
            "pgfName = '" + pdfName + '\'' +
           ",\n page = " + page +
           ",\n count = " + count +
           "\n}";
         }
        //Map map = new LinkedHashMap();
        //map.put("pgfName", pdfName);
        //map.put("page", page);
        //map.put("count", count);
        //JSONObject result = null;
       // try {
            //result = new JSONObject(map);
        //} catch (JSONException e) {
         //   throw new RuntimeException(e);
       // }
        // Для работы с json мы используем библиотеку jettison.
        // Эта библиотека использует LinkedHashMap, который поддерживает порядок атрибутов.
        // Поэтому метод toString выводит атрибуты в том порядке, в котором они добавлялись изначально.
        //return result.toString();

   // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PageEntry)) return false;
        PageEntry pageEntry = (PageEntry) o;
        return getPage() == pageEntry.getPage() && getCount() == pageEntry.getCount() && Objects.equals(getPdfName(), pageEntry.getPdfName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPdfName(), getPage(), getCount());
    }

    @Override
    public int compareTo(PageEntry o) {
        if (count < o.count) {
            return 1;
        } else if (count > o.count) {
            return -1;
        } else {
            if (page < o.page) {
                return 1;
            } else if (page > o.page) {
                return -1;
            } else {
                return getPdfName().compareTo(o.getPdfName());
            }
        }
    }
}
