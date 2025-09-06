# Learning Contract Mobile Application

A modern Android application built with Material Design 3 that displays group members and their learning contracts in an elegant, scrollable interface.

## 🚀 Features

### 📱 Modern UI/UX
- **Material Design 3** theming with automatic light/dark mode support
- **Sleek card-based layout** with rounded corners and subtle shadows
- **Color-coded sections** for different contract components
- **Circular avatar indicators** with auto-generated initials
- **Smooth scrolling** with optimized performance

### 📋 Learning Contract Display
Each group member's learning contract includes:
- **Expectations** - What they expect to achieve
- **Motivations** - What drives their learning journey
- **Contributions** - What they bring to the team
- **Hindrances** - Potential challenges they face

### 👥 Group Members
The app includes 4 team members with diverse backgrounds and learning goals:
1. **Doniele Arys A. Antonio** - Lead Android Developer focused on continuous improvement and technical excellence
2. **Francis Lorenzana** - Group Member exploring mobile development through hands-on experimentation
3. **Leigh Egino** - Group Member investigating the creative and user experience aspects of app development
4. **Ivar Duarte** - Group Member exploring advanced development concepts and modern technologies

## 🏗️ Architecture & Best Practices

### Technical Stack
- **Language**: Kotlin
- **UI Framework**: Material Design 3
- **Architecture**: Clean Architecture with MVVM principles
- **View Binding**: Type-safe view access
- **RecyclerView**: Optimized list performance with ListAdapter and DiffUtil

### Modern Android Practices
- ✅ ViewBinding for type-safe view references
- ✅ Material Design 3 color system
- ✅ Responsive design for different screen sizes
- ✅ Proper lifecycle management
- ✅ Clean separation of concerns
- ✅ Accessibility-compliant design
- ✅ Internationalization ready with string resources

## 📁 Project Structure

```
app/src/main/java/com/example/learningcontractapp/
├── MainActivity.kt                 # Main activity with RecyclerView setup
├── adapter/
│   └── GroupMemberAdapter.kt      # RecyclerView adapter with ViewHolder
├── data/
│   └── SampleData.kt             # Sample data provider
└── model/
    ├── GroupMember.kt            # Group member data class
    └── LearningContract.kt       # Learning contract data class

app/src/main/res/
├── layout/
│   ├── activity_main.xml         # Main activity layout
│   └── item_group_member.xml     # Group member card layout
├── values/
│   ├── colors.xml               # Material Design 3 color palette
│   ├── themes.xml               # Light theme definitions
│   ├── strings.xml              # String resources
│   └── dimens.xml               # Dimension resources
└── values-night/
    ├── colors.xml               # Dark theme color palette
    └── themes.xml               # Dark theme definitions
```

## 🎨 Design System

### Color Scheme
- **Primary**: Professional blue (#1565C0)
- **Secondary**: Warm amber (#7B5800) 
- **Tertiary**: Creative purple (#8E4585)
- **Error**: Alert red (#BA1A1A)
- **Surface**: Clean backgrounds with proper contrast

### Typography
- Material Design 3 type scale
- Proper hierarchy with headlines, titles, and body text
- Consistent line spacing and margins

### Spacing
- Standardized spacing system (4dp, 8dp, 16dp, 24dp, 32dp)
- Consistent card padding and margins
- Proper touch target sizes

## 🚀 Getting Started

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+ (API level 24)
- Kotlin 2.0.21+

### Running the Application
1. Open the project in Android Studio
2. Sync the Gradle files
3. Run the app on an emulator or physical device

### Customization
To add your own group members:
1. Edit `SampleData.kt`
2. Replace the sample data with your actual group members
3. Update learning contract details as needed

## 📱 Screenshots & Usage

The app displays:
- Header section with app title and description
- Scrollable list of group member cards
- Each card contains member name with avatar and complete learning contract
- Smooth animations and transitions
- Automatic theme switching based on system settings

## 🔧 Technical Details

### Dependencies
- AndroidX Core KTX
- Material Design Components
- RecyclerView with CardView
- AppCompat for backward compatibility

### Performance Optimizations
- RecyclerView with DiffUtil for efficient updates
- ViewBinding for compile-time view safety
- Proper view recycling and memory management
- Optimized layout hierarchy

## 📄 License

This project is created for educational purposes as part of a learning contract assignment.

---

**Built with ❤️ using Android Studio and Material Design 3**
