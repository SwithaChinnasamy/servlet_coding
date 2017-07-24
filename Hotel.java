import java.io.*; 
import java.sql.*; 
import java.sql.Date; 
import java.text.ParseException;
import javax.servlet.ServletException; 
import javax.servlet.http.*; 
import java.text.SimpleDateFormat; 
import javax.servlet.annotation.*;



@WebServlet("/Hotel")

public class Hotel extends HttpServlet {
    private String hotel1,food1,qty1,time1,contact1,amt1,address1;
    public void init() throws ServletException {
        


hotel1="HotelName :";
food1="FoodOrdered:";
qty1="Quantity :";
time1="Time:";
contact1="Contact:";
amt1="Amount:";
address1="Address:";


}

public void doGet(HttpServletRequest request, HttpServletResponse response) 
 throws ServletException, IOException { 

response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 

String name=request.getParameter("name"); 
String food=request.getParameter("food"); 
String quantity=request.getParameter("quantity"); 
String time=request.getParameter("time"); 
String contact=request.getParameter("contact");
String amount=request.getParameter("amount"); 
String address=request.getParameter("address"); 


try{
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "");

 PreparedStatement prestate=conn.prepareStatement("insert into food values(?,?,?,?,?,?,?)");
 //ps.executeUpdate("insert into regis values(?,?,?,?,?,?,?)");

prestate.setString(1,name); 
prestate.setString(2,food); 
prestate.setString(3,quantity); 
prestate.setString(4,time);
prestate.setString(5,contact); 
prestate.setString(6,amount); 
prestate.setString(7,address); 
int i=prestate.executeUpdate(); 
if(i>0) 
out.print("<h1>Yummyyy...<h1>"); 
out.println("<img src='/images/food.jpg' alt='success'/>");

out.println(
    
"<table border=1><tr><td><h2>"+hotel1+"</td><td><h2>"+name+"</td></h2></tr><br>"+
"<tr><td><h2>"+food1+"</td><td><h2>"+food+"</td></h2></tr><br>"+
"<tr><td><h2>"+qty1+"</td><td><h2>"+quantity+"</td></h2></tr><br>"+
"<tr><td><h2>"+time1+"</td><td><h2>"+time+"</td></h2></tr><br>"+
" <tr><td><h2>"+contact1+"</td><td><h2>"+contact+"</td></h2></tr><br>"+
" <tr><td><h2>"+amt1+"</td><td><h2>"+amount+"</td></h2></tr><br>"+
" <tr><td><h2>"+address1+"</td><td><h2>"+address+"</td></h2></tr><br>"


);

 conn.close();

 }
 catch(Exception e)
 {
 System.out.println(e);
 }
 } 
}
