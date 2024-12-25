#### Health and Fitness Tracker App - PHFtv1
This is a Health and Fitness Tracker app that helps users track their fitness goals, monitor their progress, set and review workout plans, and manage subscriptions. The app consists of various features such as tracking activity, goal setting, progress monitoring, and more.

Project Structure
1. Main Activity - MainActivity
The entry point of the app.
Displays the current time and date on the welcome screen.
Provides buttons to navigate to various parts of the app:
General User Login
Guest User Login
Sign-Up
Personal Trainer Dashboard
2. Dashboard Fragment - DashBoardFragment
Displays the user's dashboard with quick links to:
Goal Setting
Activity Categories
Tracking
Trainer Reviews
Subscription Management
Workout Plan Purchase
Also displays user details (name, age, weight, height) from the SessionManager.
3. Monitoring Fragment - MonitoringFragment
Displays a progress monitoring screen with a pie chart showing the user's goal progress.
Uses a Composable UI that renders multiple pie charts with different step goals and completion data.
4. Profile Fragment - ProfileFragment
Displays the user's profile information and provides options to:
Update Profile Information
View Workout Plans
View Subscriptions
Access Exercise Plans
Log out of the app.
5. Session Manager - SessionManager (Backend Class)
Manages user sessions and stores current user data (name, age, weight, height) which is used throughout the app.
6. SignUp, Login, and Guest User Flow - GeneralUser, GuestUser, SignUp
SignUp: Allows a new user to sign up.
GeneralUser: Allows a general user to log in with an existing account.
GuestUser: Allows a guest user to access limited functionality without logging in.
7. Goal Setting - GoalSetting
Allows users to set their fitness goals such as weight loss, steps, etc.
8. Activity Categories - ActivityCategories
Provides a list of activity categories for users to choose from.
9. Tracking - Tracking
Displays the user's activity tracking progress.
10. Subscription - Subscription
Allows users to manage their subscription to different fitness plans.
11. Payment Integration - PaymentIntegration
Provides a way for users to purchase workout plans.
12. Trainer Reviews - ReviewTrainer
Allows users to review and rate personal trainers.
13. Preset Exercise Plan - PresetExcerciePlan
Provides predefined exercise plans for the users to follow.
14. Workouts - Workouts
Provides a list of available workouts that users can follow and track.
15. Update User Info - UpdateUserInfo
Allows users to update their profile information.
16. Multi-Pie Chart - MultiPieChartScreen
Displays a multi-pie chart representing user progress toward multiple goals.
Features
User Authentication: General users can log in, while guest users can explore limited functionalities.
Real-Time Data: Displays real-time clock updates on the welcome screen.
User Dashboard: Quick access to major features like goal setting, activity tracking, and subscription management.
Progress Monitoring: Visual progress monitoring with pie charts.
Workout Plans: Provides options for users to view or purchase workout plans.
Subscriptions: Users can subscribe to various services to access exclusive content.
Profile Management: Users can view and update their profile information.
Trainer Reviews: Users can rate their trainers to provide feedback.
Technologies Used
Kotlin: Main programming language for Android development.
Jetpack Compose: For building the UI in some parts of the app, such as the progress monitoring screen with pie charts.
Android SDK: Standard tools for Android app development.
Firebase (or similar services): Not implemented in the code but assumed for session management and authentication.
SimpleDateFormat: Used for formatting and displaying the current date and time.
How to Run
Clone the repository or download the source files.
Open the project in Android Studio.
Build and run the app on an emulator or physical device.
Navigate through the app to explore its features:
Log in as a General or Guest user.
Set fitness goals, track activities, and view your progress.
Purchase subscriptions or exercise plans.
Screenshots
Screenshots for various screens like Dashboard, Profile, and Progress Monitoring (if any) can be added here.

Future Improvements
Authentication: Implement Firebase authentication for real user login and registration.
Expanded Charting: Add more detailed charts and data visualization.
Notifications: Implement push notifications for workout reminders and subscription updates.
More Fitness Plans: Include more preset exercise plans or customization options.
