using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace CaregiverService
{
    [WebService(Namespace = "http://caregiver.com/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]

    public class Recommendation
    {
        public String patient { get; set; }
        public String docRecommendation { get; set; }
    }

    public class Caregiver : System.Web.Services.WebService
    {

        [WebMethod]
        public List<Recommendation> getRecommendations(String caregiverName)
        {
            MySqlConnection mySqlConnection = new MySqlConnection("datasource=localhost;username=root;password=root");
            mySqlConnection.Open();

            List<Recommendation> list = new List<Recommendation>();

            if (mySqlConnection.State == System.Data.ConnectionState.Open)
            {
                String queryString = "SELECT patient_name, recommendation_name FROM sd_database.recommendation WHERE caregiver_name='" + caregiverName + "'";
                MySqlCommand mySqlCommand = new MySqlCommand(queryString, mySqlConnection);
                MySqlDataReader mySqlDataReader = mySqlCommand.ExecuteReader();

                while (mySqlDataReader.Read())
                {
                    list.Add(new Recommendation
                    {
                        patient = (String)mySqlDataReader.GetValue(0),
                        docRecommendation = (String)mySqlDataReader.GetValue(1)
                    });
                }
            }

            mySqlConnection.Close();

            return list;

        }
    }
}
