# Implementation Plan - Change Launcher Activity (Starting Screen)

Change the starting screen (Launcher Activity) in `AndroidManifest.xml` from `MainActivity` to `BrowseNoteActivity` (or `abbNote`).

## User Review Required

> [!IMPORTANT]
> This will make the app open directly into `BrowseNoteActivity` (the notes browsing and search page) when launched.

## Proposed Changes

### [Component] Manifest

#### [MODIFY] [AndroidManifest.xml](file:///D:/New folder/lab4.37/app/src/main/AndroidManifest.xml)
- Move the `<intent-filter>` (`MAIN` and `LAUNCHER`) from `MainActivity` to `BrowseNoteActivity` (and set `android:exported="true"` on `BrowseNoteActivity`).

## Verification Plan

### Automated Tests
- Run `./gradlew assembleDebug` to verify build success.

### Manual Verification
- Launch the app and verify that it opens directly into `BrowseNoteActivity`.
