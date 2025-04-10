# 🗺️ BroncoRadar

A modern, interactive map application for Cal Poly Pomona campus navigation.

![BroncoRadar Banner](https://img.shields.io/badge/BroncoRadar-CPP%20Map-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7.7-brightgreen)
![Java](https://img.shields.io/badge/Java-11-orange)
![HTTPS](https://img.shields.io/badge/HTTPS-Enabled-green)

## 🌟 Features

### 🗺️ Interactive Campus Map
- **OpenStreetMap Integration**: High-quality, up-to-date map tiles
- **Building Directory**: Comprehensive list of campus buildings
- **Search Functionality**: Quick search for buildings and locations
- **Responsive Design**: Works seamlessly on all devices

### 🎯 Location Services
- **Current Location**: Real-time location tracking
- **Building Labels**: Clear identification of campus buildings
- **Custom Markers**: Distinctive markers for important locations
- **Boundary Control**: Campus area restrictions for accurate navigation

### 📏 Distance Measurement
- **Point-to-Point Distance**: Measure distances between any two locations
- **Walking Time Estimation**: Automatic calculation of walking time
- **Visual Measurement Line**: Clear visual representation of routes
- **Measurement Clearing**: Easy reset of measurements

### 🔒 Security & Performance
- **HTTPS Enabled**: Secure connections for all users
- **SSL/TLS Support**: Encrypted data transmission
- **Optimized Performance**: Efficient resource utilization
- **Error Handling**: Robust error management system

## 🛠️ Technical Stack

### Backend
- **Spring Boot 2.7.7**: Modern Java framework
- **Apache Commons**: Utilities for file operations and mathematical calculations
- **Google Guava**: Core libraries for Java
- **JUnit & Mockito**: Comprehensive testing framework

### Frontend
- **Leaflet.js**: Interactive map library
- **Font Awesome**: Icon library
- **Custom CSS**: Modern, responsive design
- **JavaScript**: Dynamic functionality

### DevOps
- **GitHub Actions**: CI/CD pipeline
- **Maven**: Build automation
- **AWS EC2**: Cloud deployment
- **SSL/TLS**: Secure communication

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher
- Modern web browser

### Installation
1. Clone the repository:
```bash
git clone https://github.com/yourusername/BroncoRadar.git
```

2. Navigate to the project directory:
```bash
cd BroncoRadar
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
java -jar target/my-project-1.0-SNAPSHOT.jar
```

The application will be available at `https://localhost:443`

## 📝 Development

### Project Structure
```
BroncoRadar/
├── MVN-ProjectFolder/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   ├── resources/
│   │   │   └── static/
│   │   └── test/
│   └── pom.xml
└── .github/
    └── workflows/
```

### Testing
Run the test suite:
```bash
mvn test
```

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Acknowledgments

- OpenStreetMap for map data
- Leaflet.js for the mapping library
- Spring Boot team for the framework
- Cal Poly Pomona for campus information

---

Made with ❤️ for Cal Poly Pomona 