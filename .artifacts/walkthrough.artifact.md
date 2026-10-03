# Walkthrough - Back Button Addition

I have added a Back button to the Add Note activity (`abbNote`) to allow returning to the previous screen.

## Changes Made

### 1. UI Layout
- **[activity_abb_note.xml](file:///D:/New folder/lab4.37/app/src/main/res/layout/activity_abb_note.xml)**:
  - Added a `Button` (`id/buttonBack`) with text "Back".

### 2. Activity Logic
- **[abbNote.java](file:///D:/New folder/lab4.37/app/src/main/java/com/example/lab4/abbNote.java)**:
  - Configured `backButton` click listener to call `finish()`, returning the user to the previous activity.

## Verification Results

### Automated Tests
- Ran `./gradlew assembleDebug` - **Build Finished Successfully**.
