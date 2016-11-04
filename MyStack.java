import java.util.ArrayList;
class MyStack 
{
   private ArrayList<String> a=new ArrayList<>(10);    
   
   public boolean hasElements()
   {
      if (a.size()!=0)
         return true;
      else
         return false;
   }

   public void push(String str)
   {
      a.add(str);
   }
   
   public String pop()
   {  
      return a.remove(a.size()-1);
   }
   
   public String topElement()
   {
      return a.get(a.size()-1);
   }
   
   public void display()
   {  System.out.println("Stack:-");
      for (int i=0;i<a.size();i++)
        System.out.println(a.get(i));
   }
   
   
   
   public static void main(String args[])
   {
      MyStack s=new MyStack();
     String str[]={"[","(","{","}","{","}",")","]"};
      try
      {
      for (int i=0;i<str.length;i++)
      {          
         if (str[i]== "[" || str[i]== "{" || str[i]== "(")
            s.push(str[i]);
         else if (str[i]== "]" || str[i]== "}" || str[i]== ")")
               {
                  if (str[i]== "]")
                     if (s.topElement() == "[")
                        s.pop();
                     else   
                        throw new Exception("Mismatch error in "+str[i]);
              
                  if (str[i]== "}" )
                     if ( s.topElement() == "{")
                        s.pop();
                     else   
                        throw new Exception("Mismatch error in "+str[i]);
                     
                  if (str[i]== ")")
                     if ( s.topElement() == "(")
                        s.pop();
                     else   
                        throw new Exception("Mismatch error in "+str[i]);
                     
               }             
      }

      if (s.hasElements()) 
         throw new Exception("Bracket " + s.topElement() + " not closed");   
      else
         System.out.println("Successful");
      }      
      catch(Exception e)
      {
         System.out.println(e);
      }
   }

}