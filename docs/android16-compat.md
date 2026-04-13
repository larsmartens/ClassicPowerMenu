# Android 16 Compatibility Notes

This fork carries Android 16 compatibility work on top of upstream ClassicPowerMenu.

## Failure We Hit

The Android 16 power-menu integration changed enough that the prior hook targets were no longer reliable. Earlier builds logged class lookup failures around framework targets such as:

- `GlobalActionsDialogLite`
- `GlobalActionsComponent`
- `SystemUIApplication`

That prevented the Xposed path from initializing cleanly on Android 16.

## Fork Workflow

- keep the fix on a dedicated branch until the hook path is verified on-device
- build APKs with GitHub Actions from the fork rather than relying on local toolchain drift
- install only after preserving the previous APK and a rollback path

## Verification Standard

1. confirm the module loads without the previous class lookup failures in LSPosed logs
2. verify the phone boots cleanly after install
3. treat a real long-press power interaction as the final user-facing check when available

ADB can verify the load/init layer, but it cannot fully replace a physical power-button test.
