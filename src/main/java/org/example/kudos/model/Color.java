package org.example.kudos.model;

import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotBlank;

public class Color {

    @Id
    @NotBlank()
    private String kudosType;
    @NotBlank()
    private String headerMessage;
    @NotBlank()
    private String logoImage;
    @NotBlank()
    private String button;
    @NotBlank()
    private String buttonText;
    @NotBlank()
    private String buttonHover;
    @NotBlank()
    private String login;
    @NotBlank()
    private String loginBoxShallow;
    @NotBlank()
    private String fieldsBoxShallow;

    public Color(@NotBlank() String kudosType, @NotBlank() String headerMessage, @NotBlank() String logoImage,
                 @NotBlank() String button, @NotBlank() String buttonText, @NotBlank() String buttonHover,
                 @NotBlank() String login, @NotBlank() String loginBoxShallow, @NotBlank() String fieldsBoxShallow) {
        this.kudosType = kudosType;
        this.headerMessage = headerMessage;
        this.logoImage = logoImage;
        this.button = button;
        this.buttonText = buttonText;
        this.buttonHover = buttonHover;
        this.login = login;
        this.loginBoxShallow = loginBoxShallow;
        this.fieldsBoxShallow = fieldsBoxShallow;
    }

    public String getKudosType() { return kudosType; }
    public String getHeaderMessage() { return headerMessage; }
    public String getLogoImage() {return logoImage; }
    public String getButton() { return button; }
    public String getButtonText() { return buttonText; }
    public String getButtonHover() { return buttonHover; }
    public String getLogin() { return login; }
    public String getLoginBoxShallow() { return loginBoxShallow; }
    public String getFieldsBoxShallow() { return fieldsBoxShallow; }
}


