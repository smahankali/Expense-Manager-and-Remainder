# Expense-Manager-and-Remainder
App Proposal:

The name of the application is Bills Manager and Reminder.  The app is used to store our past expenses and even allows us to set reminders for the upcoming payments in the future. 

Code Description:

 Intro and Purpose, AVD specification
The name of the application is Bills Manager and Reminder.  The app is used to store our past expenses and even allows us to set reminders for the upcoming payments in the future. 
The project is built with tools version 25.0.1 and compiled for sdk version 25.  The minimum sdk is version 15 and the target sdk is 25.  The project depends on the support appcompat -v7:25.0.1, support design 25.0.1, support:cardview-v7:25.0.1, support:support -v4:25.0.1. It also requires additional permissions like write external storage, write internal storage permission, wake_lock permissions. 

 Code Description

1)	AlarmActivity : This activity is a java class used to display activity layout for the alarm layout resource file. This activity layout is used to set the alarm for the payment reminder. It contains date and time pickers.

2)	AlarmManagerBroadCastReceiver : This java class extends BroadCastReceiver which is used to call the alarm in our mobile and set the alarm.


3)	DbOperation : This java class extends the SQLiteOpenHelper and is used for creation and handling the database object. This class creates the database tables if they are not existed prior to the call.

4)	DisplayReminderFragment : This java fragment is called when it is needed to display all the reminders in order. This contains a recycler view to which the data from the database is attached using cursor and adapters.


5)	ExpenseFragment : This java fragment is called to enter and save a expense. This stores the name, amount, comments and image of the bill in the database on clicking the save button.

6)	ExpenseReportFragment : This java fragment is called to display all the the expenses that are stored in the database. There is a choice to display expenses occurred in the given period of dates when dates are entered. The expenses are sorted in the order by the name and displayed.


7)	itemViewHolder : This java class extends RecyclerView.ViewHolder and is used to customize the row displayed in the recycler view. It binds the items in a row to the viewholder and is attached to the recyclerviewadapter.
8)	LoginActivity : This java class is the activity and the launching activity of the application. This validates the credentials entered and allows user to login into the application.

9)	MainActivity: This java class is the main activity which contains a navigation bar and toolbar. This activity has a fragment which is replaced based on the items selected in the navigation bar. This also a menu bar which contains a logout option allowing user to logout from the app.


10)	RecyclerViewadapter : This java class extends the RecyClerViewadapter<item> that is used to add the rows to the recyclerview which was customized according to the needs. This adapter is attached to the recyclerview in different layouts.

11)	ReminderFragment: This java class is used to set reminder for the future payments. This store the name, amount, payment due date and comments and allows a user to set the alarm for reminder and saving it to databse.


12)	ReportItem : It is a java class used to instantiate the row items for the card view in 
recycler view.








