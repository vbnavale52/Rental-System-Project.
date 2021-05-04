import "./App.css";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Navbar from "./Components/Navigation/Navbar";
import Footer from "./Components/Footer";
import About from "./Common/Pages/About";
import Contact from "./Common/Pages/Contact";
import LoginPage from "./Common/LoginPage"
import Home from "./Common/Pages/Home"
import UserProfile from "./CustomerScreen/UserProfile"
import ViewProfile from "./CustomerScreen/ViewProfile"
import UserRegister from "./CustomerScreen/UserRegistration"
import Example from "./CustomerScreen/Example"
import FileUpload from "./CustomerScreen/FileUpload"
import SignUpPage from "./CustomerScreen/SignUpPage"

//import Dashboard from "./Admin/components/pages/Dashboard";

function App() {
  return (
    <div className="App">
      {/* User Routing.......*/}
      <Router>
        <Navbar />
        <div >
          <Switch>
            <Route path="/" exact component={Home} />
            <Route path="/home" exact component={Home} />
            <Route path="/about_us" exact component={About} />
            <Route path="/contact_us" exact component={Contact} />
            <Route path="/sign_up" exact component={UserRegister} />

            <Route path="/sign_in" exact component={LoginPage} />
            <Route path="/user_profile" component={UserProfile} />
            <Route path="/view_profile" component={ViewProfile} />
            <Route path="/upload_file" component={FileUpload} />
            <Route path="/myaccount/profile" component={ViewProfile} />

            <Route path="/sign_up1" component={SignUpPage} />

            {/*<Route path="/dashboard" component={Dashboard} />*/}
          </Switch>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
