# Activity 5 - Record Management System with Enhanced UI

## Overview
This is a Java console application that implements a Record Management System using LinkedList data structures. The application has been enhanced with a modern, colorful user interface for better user experience.

## Features

### 🎨 Enhanced User Interface
- **Colorful Console Output**: Uses ANSI color codes for better visual appeal
- **Box-drawing Characters**: Professional-looking borders and menus
- **Clear Screen Functionality**: Automatic screen clearing for better navigation
- **Status Icons**: Visual indicators (✓, ❌, ⚠️, 📝) for different states
- **Formatted Tables**: Well-structured display of records

### 📋 Core Functionality
1. **Add Record to First** - Add new records at the beginning of the list
2. **Add Record to Last** - Add new records at the end of the list
3. **Remove First Record** - Remove the first record from the list
4. **Remove Last Record** - Remove the last record from the list
5. **Display All Records** - Show all records in a formatted table
6. **Display Specific Record** - View a specific record by number
7. **Edit Record** - Modify existing records with validation

### 🔧 Technical Features
- **File Persistence**: All changes are automatically saved to `records.txt`
- **Input Validation**: Comprehensive validation for all user inputs
- **Error Handling**: Graceful error handling with user-friendly messages
- **Data Integrity**: Ensures data consistency across operations

## File Structure
```
Activity5_DSA/
├── src/
│   └── Activity_5.java          # Main application source code
├── bin/
│   └── Activity_5.class         # Compiled Java bytecode
├── records.txt                  # Data file (name,age,gender format)
└── README.md                    # This documentation
```

## How to Run

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Windows PowerShell or Command Prompt

### Compilation
```powershell
javac -d bin src/Activity_5.java
```

### Execution
```powershell
java -cp bin Activity_5
```

## Data Format
The application uses a simple CSV format for storing records:
```
Name,Age,Gender
Ana,12,Female
Bing,14,Female
Cathy,16,Female
Dolly,13,Female
Eric,14,Male
```

## UI Color Scheme
- 🔵 **Blue**: Welcome messages and headers
- 🟣 **Purple**: Main menu borders
- 🟡 **Yellow**: Instructions and warnings
- 🟢 **Green**: Success messages and confirmations
- 🔴 **Red**: Error messages and invalid inputs
- 🔵 **Cyan**: Input prompts and information
- ⚪ **White**: Default text
- **Bold**: Emphasized text

## Sample Output

### Welcome Screen
```
╔══════════════════════════════════════════════════════════════╗
║                    RECORD MANAGEMENT SYSTEM                   ║
║                        Activity 5 - DSA                       ║
╚══════════════════════════════════════════════════════════════╝

✓ System initialized successfully!
✓ Records loaded from file: 5 entries found
```

### Main Menu
```
╔══════════════════════════════════════════════════════════════╗
║                         MAIN MENU                            ║
╠══════════════════════════════════════════════════════════════╣
║  [1] Add Record to First                                    ║
║  [2] Add Record to Last                                     ║
║  [3] Remove First Record                                   ║
║  [4] Remove Last Record                                    ║
║  [5] Display All Records                                   ║
║  [6] Display Specific Record                               ║
║  [7] Edit Record                                           ║
║  [0] Exit                                                  ║
╚══════════════════════════════════════════════════════════════╝
```

### Records Display
```
╔══════════════════════════════════════════════════════════════╗
║                        ALL RECORDS                            ║
╠══════════════════════════════════════════════════════════════╣
║  1. Ana             | 12  | Female                    ║
║  2. Bing            | 14  | Female                    ║
║  3. Cathy           | 16  | Female                    ║
║  4. Dolly           | 13  | Female                    ║
║  5. Eric            | 14  | Male                      ║
╚══════════════════════════════════════════════════════════════╝
✓ Total records: 5
```

## Input Validation
- **Name**: Cannot be empty
- **Age**: Must be numeric only
- **Gender**: Must be "Male" or "Female" (case-insensitive)
- **Record Numbers**: Must be within valid range
- **Menu Choices**: Must be between 0-7

## Error Handling
- Invalid inputs are caught and user-friendly error messages are displayed
- File operations are wrapped in try-catch blocks
- Graceful handling of missing or corrupted data files

## Technical Implementation
- Uses `LinkedList<String>` for efficient add/remove operations
- Implements file I/O with automatic persistence
- Modular design with separate methods for each functionality
- ANSI escape codes for terminal colors and formatting
- Scanner-based input with proper resource management

## Notes
- The application automatically creates `records.txt` if it doesn't exist
- All changes are immediately saved to the file
- The interface is designed to work in most modern terminal environments
- Color support may vary depending on the terminal application used
