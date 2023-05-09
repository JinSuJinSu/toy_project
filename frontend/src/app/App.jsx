import { useRoutes } from "react-router-dom";
import { MatxTheme } from "./layouts";
import { SettingsProvider } from "./contexts/SettingsContext";
import routes from "./routes";
import { UserContext } from "./contexts/UserContext";

const App = () => {
  const content = useRoutes(routes);

  return (
    <SettingsProvider>
      <UserContext.Provider value="hjs429">
        <MatxTheme>{content}</MatxTheme>
      </UserContext.Provider>
    </SettingsProvider>
  );
};

export default App;
