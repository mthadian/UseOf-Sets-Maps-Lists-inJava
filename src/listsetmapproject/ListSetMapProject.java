/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listsetmapproject;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

/**
 *
 * @author thadian
 */
public class ListSetMapProject extends AbstractMap
{
    
    private final List listOfKeys = new ArrayList();
    private final List listofValues = new ArrayList();


    @Override 
    public Object put(Object key, Object value) 
{
    Object result = get(key);
    if (listOfKeys.contains(key))
        listofValues.set(listOfKeys.indexOf(key), value);
    else {
        listOfKeys.add(key);
        listofValues.add(value);
        }
        return result;
}

    @Override
    public Object get(Object key)
{
    if (!listOfKeys.contains(key))
    return null;
   return listofValues.get(listOfKeys.indexOf(key));
}

    @Override
    public Set entrySet()
{
    Set Inputs = new HashSet();
    Iterator ky = listOfKeys.iterator();
    Iterator vl = listofValues.iterator();
    while (ky.hasNext())
    Inputs.add(new Mapfinal(ky.next(), vl.next()));
   return Inputs;
}

    @Override
    public String toString()
{
    StringBuilder s = new StringBuilder("{");
    Iterator cKey = listOfKeys.iterator(), vi = listofValues.iterator();
    while (cKey.hasNext())
    {
    s.append(cKey.next()).append("=").append(vi.next());
    if (cKey.hasNext())
    s.append(", ");
    }
    s.append("}");
    return s.toString();
}

 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        // TODO code application logic here
        ListSetMapProject map1 = new ListSetMapProject();
        map1.put("Patrick", "0716769487");
        map1.put("Jane", "0756456234");
        map1.put("Kamau", "0745768342");
        map1.put("Martin", "0745126543");
        map1.put("Carol", "0745836234");
        map1.put("Samson", "0712927562");
        map1.put("Millicent", "0718576129");
        System.out.println(map1);
    }
    
   
} 


class Mapfinal implements Entry, Comparable
{
    Object keys, values;
    Mapfinal(Object i, Object j)
    {
        keys = i;
        values = j;
    }
    @Override
    public Object getKey()
    {
        return keys;
    }
    @Override
    public Object getValue()
    {
        return values;
    }
    @Override
    public Object setValue(Object val)
    {
        Object result = values;
        values = val;
        return result;
    }
    @Override
    public boolean equals(Object obj) 
    {
        return keys.equals(((Mapfinal)obj).keys);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.keys);
        hash = 97 * hash + Objects.hashCode(this.values);
        return hash;
    }

   
    @Override
    public int compareTo(Object rv) 
    {
        return ((Comparable)keys).compareTo(
        ((Mapfinal)rv).keys);
    }
    

    
  

    
}
