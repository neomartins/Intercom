# Intercom
Intercom Test

# Core
Core class has 3 methods.
readCustomer, this method is the method that will read the file. He receive only the path. I use the RandomAccessFile to read line by line and creat a List with all information I need, and return this list.
The methodo getNearCustomer, receive 3 parameters, List of client, latitude and lonfitude from the officie, and retunr a list with users within 100km from the officie.
The writeCustomertoFile receive List and the path to record.

#DublinOffice
This class has only the main method to run the project, I am using the parameters from the main method to pass the path from 
the txt file to read and get the list of customers, and the second parameter is where I will save the new txt file with the
customer within 100km from the office.

#CustomerBean
This class is the classic BEAN to get and set the variables from the text file.
In this class I use the comparable class to sort the customer's.

# ArrayConvert
This class has one method, this method will receive a array and will flatten this array.
If the element inside the array is a Integer element the method will add this element into a array, 
if this element is not a integer, I will send this array back to my method recursively.

#CoreTest
To test the Core classe I am using the Junit.
Inseide the CoreTest I have 4 methodos.
The first one loadTest.
Is to delete the file that the program will record after run.
The method read Customer Test, will verify if exist the file and will see the length of the file is correct.
The method get NearCustomerTest, will read the file and verify if the return is like 16 lines.
The method writeCustomertoFileTest, will verify if the system recorded the file.

#ArrayConvertTest
This class has two methods to test the method flatten.
The first method i pass a array [1, 2, [3], 4] and the method verify if the return is {1 ,2 ,3 ,4}
The second i pass a array {1,2, {3, {4,5}},6,7} and the method verify if the return is {1,2,3,4,5,6,7}.

Run project.
The project has 2 class to run.
The DublinOffice, to run this class you have to run this command 
java DublinOffice path( where the customer list is in your pc) path( where the system will save the new list).
To run the flatten.
just rund java ArrayFlatten.


