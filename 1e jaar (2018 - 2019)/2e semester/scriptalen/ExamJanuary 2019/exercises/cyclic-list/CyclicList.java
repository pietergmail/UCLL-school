import java.util.*;


public class CyclicList
{
    private ArrayList<Object> items;

    /*
      Twee constructoren. Python ondersteunt in tegenstelling
      tot Java geen overloading: je kan dus maar
      een enkele constructor definieren.

      Maak gebruik van default parameter values
      om dezelfde functionaliteit te bekomen.
     */
    public CyclicList()
    {
        items = new ArrayList<Object>();
    }

    public CyclicList(ArrayList<Object> xs)
    {
        items = new ArrayList<Object>(xs);
    }

    /*
          xs.size()

      moet in Python geschreven worden als

          len(xs)
     */
    public int size()
    {
        return items.size();
    }

    /*
          xs.at(i)

      moet in Python geschreven worden als

          xs[i]
     */
    public Object at(int index)
    {
        return items.get(index % size());
    }

    public void add(Object item)
    {
        items.add(item);
    }

    /*
          xs.concatenate(ys)
      
      moet in Python geschreven worden als

          xs + ys
     */
    public CyclicList concatenate(CyclicList xs)
    {
        CyclicList result = new CyclicList(items);

        for ( Object x : xs.items )
        {
            result.add(x);
        }

        return result;
    }

    /*
          xs.isEmpty()

      moet in Python geschreven worden als

          xs.is_empty
     */
    public boolean isEmpty()
    {
        return size() == 0;
    }
}
