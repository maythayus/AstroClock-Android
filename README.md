# AstroClock

> An experimental Android clock whose indicator follows the device's motion.

AstroClock is an early Jetpack Compose prototype: it shows the current time, a triangular
indicator that rotates with the gyroscope, and a night-mode toggle. Built with Kotlin and
Material 3.

> **Status:** prototype / work in progress. Expect rough edges and missing build scaffolding.

---

## Features

- **Live clock** — current time refreshed continuously
- **Motion indicator** — a triangle rotated in real time by the gyroscope sensor
- **Hour-based colour** — the indicator shifts colour at key hours of the day
- **Night mode** — togglable darker display
- **Material 3 UI** — built entirely with Jetpack Compose

---

## Tech Stack

| Layer | Library / Tool |
|---|---|
| Language | Kotlin |
| UI | Jetpack Compose + Material 3 (Compose BOM 2023.10.01) |
| Sensors | `SensorManager` — gyroscope (`TYPE_GYROSCOPE`) |
| Time | `java.time.LocalTime` |
| Min SDK | 33 (Android 13) |
| Target SDK | 34 (Android 14) |

---

## Requirements

- A device (or emulator) with a **gyroscope** — the motion indicator depends on it
- Android 13 (API 33) or newer

---

## Getting Started

The app module lives under [`AstroClock-Android/app/`](AstroClock-Android/app). Open that
project in **Android Studio** (Hedgehog or later), let Gradle sync, then run on a device or
emulator.

A GitHub Actions workflow ([`.github/workflows/build-apk.yml`](.github/workflows/build-apk.yml))
is set up to build a release APK on each push to `main`.

```bash
git clone https://github.com/maythayus/AstroClock-Android.git
```

---

## Support the Project

- 📺 [YouTube — @maythayus1](https://www.youtube.com/@maythayus1?sub_confirmation=1)
- 🎵 [SoundCloud](https://soundcloud.com/user-807863479-448305626)
- 🛒 [Store](https://maythayus1.store/)

---

## License

No license has been published for this repository yet. Until one is added, all rights are
reserved by the author.
