# Implementation Plan - MVC Software Architectural Pattern for Notes

Implement the MVC (Model-View-Controller) architectural pattern by introducing/refining `NoteController` as the Controller between `abbNote` (View) and `TextNote`, `CheckListNote`, and `Note` (Models).

## User Review Required

> [!NOTE]
> `abbNote` acts as the View (AddNoteActivity equivalent) in the current project structure, and is registered in the Android Manifest.

## Proposed Changes

### [Component] Models

#### [MODIFY] [CheckListNote.java](file:///D:/New folder/lab4.37/app/src/main/java/com/example/lab4/CheckListNote.java)
- Make `CheckListNote` extend `Note` to inherit `title`, `content`, `createdDate`, and date formatting.
- Add constructors and update `getSummary()` to include checklist details and creation date.

### [Component] Controller

#### [MODIFY] [NoteController.java](file:///D:/New folder/lab4.37/app/src/main/java/com/example/lab4/NoteController.java)
- Update `NoteController` to manage both `TextNote` and `CheckListNote`.
- Provide methods to save/process text notes and checklist notes and update the View (`abbNote`).

### [Component] View

#### [MODIFY] [abbNote.java](file:///D:/New folder/lab4.37/app/src/main/java/com/example/lab4/abbNote.java)
- Update UI interaction to delegate note creation and display logic to `NoteController`.

## Verification Plan

### Automated Tests
- Run `./gradlew assembleDebug` to verify compilation and build success.

### Manual Verification
- Deploy and test the Add Note screen (`abbNote`) to verify that notes are successfully created via `NoteController` and displayed correctly.
